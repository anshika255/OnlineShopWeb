import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, PatternValidator} from '@angular/forms'


/**
 ** @param form

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
  selector: 'app-forget',
  templateUrl: './forget.component.html',
  styleUrls: ['./forget.component.css']
})
export class ForgetComponent implements OnInit {

  forgetForm: FormGroup;
  
  constructor(private builder: FormBuilder){}

  ngOnInit() {
    this.buildForm()
  }

  buildForm() {
    this.forgetForm = this.builder.group({
      otp: ['', [Validators.required, Validators.pattern('[0-9]{6}')]],
      password: ['', [Validators.required, symbolValidator, Validators.minLength(6)]],
      confirmPassword: '',
    }, {
      validators: passwordsMatchValidator
    })
  }

  signup() {
    console.log(this.forgetForm.value)
  }

}