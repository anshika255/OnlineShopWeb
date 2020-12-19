import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, PatternValidator} from '@angular/forms'
import { Router } from '@angular/router';
import { UserLoginService } from 'src/app/user-login.service';
import { User } from 'src/app/user.model';

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
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{
  usr = new User;
  
  registerForm: FormGroup;
  
  constructor(private builder: FormBuilder,private service: UserLoginService, private router: Router){}

  ngOnInit() {
    this.buildForm()
  }

  buildForm() {
    this.registerForm = this.builder.group({
      yourname: ['', [Validators.required,Validators.pattern('(([A-Z][a-z]*((\s[A-Za-z])?[a-z]*)*))')]],
      mobileno: ['', [Validators.required, Validators.pattern('([6789][0-9]{9})')]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, symbolValidator, Validators.minLength(6)]],
      confirmPassword: ''
    }, {
      validators: passwordsMatchValidator
    })
  }

  

  register()
  {
    this.service.save(this.usr);
    this.router.navigate(['/login']);
  } 


}