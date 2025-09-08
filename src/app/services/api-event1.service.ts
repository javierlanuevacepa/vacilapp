import { HttpClient,HttpErrorResponse  } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ApiEvent1Service {

  constructor(private http: HttpClient) { }



  private usuario: any;

  setUsuario(us:any){
    this.usuario = us;
  }

  



  getEventos(): Observable<any> {
    return this.http.get(`${environment.baseUrl}/evento`); 
  }

  iniciarSesion(nombreUsuario:string,contrasena:string): Observable<any> {
    return this.http.post(`${environment.baseUrl}/usuario/iniciarSesion/${nombreUsuario}YkdnM${contrasena}`,{}).pipe(
      catchError(this.handleError)
    );
  }

  getEventosEnRadioDe(longitudUser:number,latitudUser:number,radioKilo:number){
    return this.http.get(`${environment.baseUrl}/evento/enRadiode/${latitudUser}/${longitudUser}/${radioKilo}`); 
  }

  private handleError(error: HttpErrorResponse): Observable<never> {
    if (error.status === 401) {
      // Error de autenticación
      return throwError(() => new Error('Usuario o contraseña incorrectos.'));
    } else {
      // Otros errores
      return throwError(() => new Error('Ocurrió un error. Por favor, intenta de nuevo más tarde.'));
    }
  }

}
