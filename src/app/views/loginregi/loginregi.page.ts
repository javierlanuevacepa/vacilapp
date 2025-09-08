
import { Component, OnInit } from '@angular/core';
import { ToastController,LoadingController } from '@ionic/angular';
import { Router } from '@angular/router';
import {ApiEvent1Service} from '@services/api-event1.service'
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-loginregi',
  templateUrl: './loginregi.page.html',
  styleUrls: ['./loginregi.page.scss'],
})
export class LoginregiPage implements OnInit {


  

  constructor(private toastController: ToastController,private router: Router,private loadingCtrl: LoadingController,private apiServicio:ApiEvent1Service) { }

  ngOnInit() {
  }


  async showLoading(usuario:string) {
    const loading = await this.loadingCtrl.create({
      message: 'Inicio de sesión exitoso, ¡bienvenido!, '+usuario,
      duration: 1500,
    });

    loading.present();
  }


  regisTer:boolean = false;

  usuario:string = "";
  contrasen:string ="";
  correo:string ="";
  rut:string = "";

  used:any = null;
  


  iniciarSesion(){
    if (this.usuario!="" && this.contrasen!=""){
       this.apiServicio.iniciarSesion(this.usuario,this.contrasen).subscribe({
        next: async (response)=>{
          

          this.showLoading(response.nombreUsuario);
          
          this.router.navigate(['/home/mapavista'],{
            state:{
              usuarion:response
            }
          })
          
        },
        error:async(error:Error)=>{
          console.log(error)
          this.toastNotificacion('top','Usuario o contraseña incorrectos!',1500);
        }
      })

    }else{
      this.toastNotificacion('bottom','Uno o mas campos invalidos',1500);
    }
    
  }

  async toastNotificacion(position: 'top' | 'middle' | 'bottom',mensaje:string,duracion:number) {
    const toast = await this.toastController.create({
      message: mensaje,
      duration: duracion,
      position: position,
    });
    await toast.present();
  }


}
