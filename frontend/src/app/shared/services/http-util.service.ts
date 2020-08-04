import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { environment as env } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HttpUtilService {
  
  private
  private readonly PATH_DEVOLUCOES: string = 'aluguel/devolucoesprevistas';
  private readonly PATH_ALUGUEIS: string = 'aluguel/alugadosnasemana';

  constructor(private http: HttpClient) { }

  buscarDevolucoes(page: number, size: number): Observable<any> {
    const url: string = env.baseUrl + this.PATH_DEVOLUCOES;
    const params: string = '?page=' + page + '&size=' + size;

    return this.http.get(url + params);
  }

  buscarAlugueis(page: number, size: number): Observable<any> {
    const url: string = env.baseUrl + this.PATH_ALUGUEIS;
    const params: string = '?page=' + page + '&size=' + size;

    return this.http.get(url + params);
  }
}
