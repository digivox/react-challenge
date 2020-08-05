import { Component, OnInit } from '@angular/core';
import { HttpUtilService } from '../shared/services/http-util.service';
import { Aluguel } from '../shared/models/Aluguel.model';
import { MatTableDataSource } from '@angular/material/table';
import { PageEvent } from '@angular/material/paginator';

import * as moment from 'moment';

@Component({
  selector: 'app-list-devolucoes',
  templateUrl: './list-devolucoes.component.html',
  styleUrls: ['./list-devolucoes.component.css']
})
export class ListDevolucoesComponent implements OnInit {

  dataSource: MatTableDataSource<Aluguel>;
  totalDevolucoes: number;
  colunas: string[] = ['titulo',  'subtitulo', 'nomeCliente', 'cpf', 'dataDevolucao', 'status'];

  private pagina: number;

  constructor(private httpUtil: HttpUtilService) { }

  ngOnInit(): void {
    this.pagina = 0;
    this.exibirDevolucoes();
  }

  exibirDevolucoes() {
    this.httpUtil.buscarDevolucoes(this.pagina, 25).subscribe( data => {
      this.totalDevolucoes = data.totalElements;
      const alugueis = data.content as Aluguel[];
      this.dataSource = new MatTableDataSource<Aluguel>(alugueis);
    });
  }

  paginar(pageEvent: PageEvent) {
    this.pagina = pageEvent.pageIndex;
    this.exibirDevolucoes();
  }

}
