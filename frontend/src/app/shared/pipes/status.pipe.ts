import { Pipe, PipeTransform } from '@angular/core';
import { Status } from '../models';

@Pipe({
  name: 'status'
})
export class StatusPipe implements PipeTransform {

  transform(status: Status, args?: any): String {
    return this.obterTexto(status);
  }

  obterTexto(status: Status): string {
  	let statusDesc: string;
  	switch (status) {
  		case Status.EM_ANDAMENTO:
  			statusDesc = 'Início do trabalho';
  			break;
  		case Status.RESERVADO:
  			statusDesc = 'Início do almoço';
  			break;
  		case Status.FINALIZADA:
  			statusDesc = 'Término do almoço';
  			break;
  		case Status.CANCELADO:
  			statusDesc = 'Término do trabalho';
  			break;
  		default:
  			statusDesc = status;
  			break;
  	}
  	return statusDesc;
  }

}
