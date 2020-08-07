import { Component, OnInit } from '@angular/core';
import { HttpUtilService } from '../shared/services/http-util.service';
import { MatTableDataSource } from '@angular/material/table';
import { Aluguel } from '../shared/models/Aluguel.model';
import { PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-list-alugueis',
  templateUrl: './list-alugueis.component.html',
  styleUrls: ['./list-alugueis.component.css']
})
export class ListAlugueisComponent implements OnInit {

  dataSource: MatTableDataSource<Aluguel>;
  totalDevolucoes: number;
  colunas: string[] = ['titulo',  'subtitulo', 'nomeCliente', 'cpf', 'dataDevolucao', 'status'];

  private pagina: number;

  constructor(private httpUtil: HttpUtilService) { }

  ngOnInit(): void {
    this.pagina = 0;
    this.exibirAlugueis();
  }

  exibirAlugueis() {
    this.httpUtil.buscarAlugueis(this.pagina, 25).subscribe( data => {
      this.totalDevolucoes = data.totalElements;
      const alugueis = data.content as Aluguel[];
      this.dataSource = new MatTableDataSource<Aluguel>(alugueis);
    });
  }

  paginar(pageEvent: PageEvent) {
    this.pagina = pageEvent.pageIndex;
    this.exibirAlugueis();
  }


}
