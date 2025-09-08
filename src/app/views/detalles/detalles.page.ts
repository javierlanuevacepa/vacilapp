import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';


@Component({
  selector: 'app-detalles',
  templateUrl: './detalles.page.html',
  styleUrls: ['./detalles.page.scss'],
})
export class DetallesPage implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
    const navigation = this.router.getCurrentNavigation();
    if (navigation?.extras.state) {
      const { evento } = navigation.extras.state as any;
      this.eventoDetalle = evento
      console.log(this.eventoDetalle);
    }else{
      this.router.navigate(['/home'] );
    }
  }

  eventoDetalle:any = {}


  likeCarrret(){
    if (this.eventoDetalle.userliked===true){
      this.eventoDetalle.likes = this.eventoDetalle.likes-1
      this.eventoDetalle.userliked = false;
    }else if(this.eventoDetalle.userliked===false){
      this.eventoDetalle.likes = this.eventoDetalle.likes+1
      this.eventoDetalle.userliked = true;
    }
  }
}
