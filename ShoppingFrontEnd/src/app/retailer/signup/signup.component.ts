import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, PatternValidator} from '@angular/forms'
import { Router } from '@angular/router';
import { RetailerLoginService } from 'src/app/retailer-login.service';
import { Retailer } from 'src/app/retailer.model';

/**
 * 
 * @param form 
 */

function passwordsMatchValidator(form) {
  const password = form.get('password')
  const confirmPassword = form.get('confirmPassword')

  if(password.value !== confirmPassword.value) {
    confirmPassword.setErrors({ passwordsMatch: true })
  } else {
    confirmPassword.setErrors(null)
  }

  return null
}

/**
 * If the data is valid return null else return an object
 */
function symbolValidator(control) { //control = registerForm.get('password')
  if(control.hasError('required')) return null;
  if(control.hasError('minlength')) return null;

  if(control.value.indexOf('@') > -1) {
    return null
  } else {
    return { symbol: true }
  }
}
 

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  rtlr = new Retailer;

  signupForm: FormGroup;
  
  constructor(private builder: FormBuilder,private service: RetailerLoginService, private router: Router){}

  ngOnInit() {
    this.buildForm()
  }

  buildForm() {
    this.signupForm = this.builder.group({
      yourname: ['', [Validators.required,Validators.pattern('(([A-Z][a-z]*((\s[A-Za-z])?[a-z]*)*))')]],
      mobileno: ['', [Validators.required, Validators.pattern('([6789][0-9]{9})')]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, symbolValidator, Validators.minLength(6)]],
      confirmPassword: ''
    }, {
      validators: passwordsMatchValidator
    })
  }

  register() {
    console.log(this.signupForm.value)
  }
  registerRetailer()
  {
    this.service.save(this.rtlr);
    this.router.navigate(['/signin']);
  } 

}