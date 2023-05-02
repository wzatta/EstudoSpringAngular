import { LoginInterface } from './../../cadastro/model/LoginInterface';
import { Component, OnInit } from '@angular/core';
import { UserloginService } from '../../servicesapp/userlogin.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { tap, Observable, map, catchError } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

 formlogin = this.formBuilder.group({
  userName :['',[Validators.required]],
  password :['',[Validators.required]]
 });

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private userLogSev : UserloginService,
    private snackBar: MatSnackBar
  ){}

  ngOnInit(): void {

    this.formlogin.setValue(
      {
        userName:'',
        password:'',
      }
    );
  }

  logar(){
    if(this.formlogin.invalid) return;
    var usuario = this.formlogin.getRawValue() as LoginInterface;
    this.userLogSev.logar(usuario).subscribe(
      (response) => {
        if(response){
          window.location.reload();
        }
      }
    );
  }


}




