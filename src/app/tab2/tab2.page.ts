import { Component, OnInit } from '@angular/core';
import { AlertController,IonRouterOutlet } from '@ionic/angular';

import {ApiEvent1Service} from '../services/api-event1.service'

import { Router } from '@angular/router';

import * as L from 'leaflet';


const iconRetinaUrl = 'https://unpkg.com/leaflet@1.7.1/dist/images/marker-icon-2x.png';
const iconUrl = 'https://unpkg.com/leaflet@1.7.1/dist/images/marker-icon.png';
const shadowUrl = 'https://unpkg.com/leaflet@1.7.1/dist/images/marker-shadow.png';


const defaultIcon = L.icon({
  iconRetinaUrl,
  iconUrl,
  shadowUrl,
  iconSize: [25, 41],
  iconAnchor: [12, 41],
  popupAnchor: [1, -34],
  tooltipAnchor: [16, -28],
  shadowSize: [41, 41]
});



@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page implements OnInit{

  

  map!: L.Map;
  
  
  usuario = new Array();

  eventos: any[] = [];


  masCotizados10km: any[] = [];

  
  constructor(private alertController: AlertController,private router: Router,private apiServicio:ApiEvent1Service,private routerOutlet: IonRouterOutlet) {}

  ngOnInit() {

    this.routerOutlet.swipeGesture = false;
    const navigation = this.router.getCurrentNavigation();

    if (navigation?.extras.state){
      const {usuarion} = navigation.extras.state as any;
      this.usuario = usuarion

      this.apiServicio.getEventos().subscribe((data)=>{
        this.eventos = data;
      });

    }else{
      this.router.navigate(['/loginregi']);
    }




    
  }

 

  ionViewDidEnter(){
    this.loadMap();
  }



  quickSort(){
    
  }

  

  
  handleRefresh(event:any) {
    setTimeout(() => {
      this.map.remove();
      this.loadMap();
      event.target.complete();
    }, 1000);
  }


  loadMap() {
    // Inicializar el mapa centrado en una ubicación
    this.map = L.map('map', {minZoom:13,maxZoom:17}).setView([-33.499748, -70.666624], 13);

    // Agregar capa de OpenStreetMap
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png').addTo(this.map);

    // Añadir los marcadores
    this.eventos.forEach((markerData) => {
      const marker = L.marker([markerData.latitud, markerData.longitud], {icon: defaultIcon}).addTo(this.map);
      marker.bindPopup(markerData.nombreCarrete);


      //IF ESTA A 10 KILOMETROS DE TI MOSTRAR
      marker.openPopup();
      //ELSE NO 


      marker.on('click',()=>{


        this.router.navigate(['/detalles'],{
          state:{
            evento:markerData
          }
        })
      });
    });
    // USER 

    this.map.locate({ setView: true, maxZoom: 16 });

    // Evento que se activa cuando la ubicación es encontrada
    this.map.on('locationfound', (e: any) => {
      const userLocation = e.latlng; // Obtener latitud y longitud

      // Agregar un marcador en la ubicación del usuario
      L.marker([userLocation.lat, userLocation.lng], {icon:defaultIcon})
        .addTo(this.map)
        .bindPopup('Este eres tú')
        .openPopup();

      // Opcional: Dibujar un círculo alrededor de la ubicación del usuario
     // L.circle([userLocation.lat, userLocation.lng], {
     //   radius: e.accuracy, // Radio del círculo basado en la precisión
     // }).addTo(this.map);
    });
    // Evento que se activa si la geolocalización falla
    this.map.on('locationerror', (e: any) => {
      alert('Ubicación no disponible.');
    });
  }

  enviarDetalles(evento:any){
    this.router.navigate(['/detalles'],{
      state:{
        evento:evento
      }
    })   
  }



  async showDetails(header:string,subheader:string,messe:string,event:any){
    const alert = await this.alertController.create({
      header: header,
      subHeader:subheader,
      message:messe,
      buttons: [
          {
              text: 'Volver',
              role: 'cancel',
              cssClass: 'secondary'
          }, 
          {
              text: 'DETALLES 🔥',
              handler: (alertData: any) => {
               
              }
          }
      ]
  });
  alert.present();
  }


}
