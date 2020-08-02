import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { FormGroup, FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-cliente-form',
  templateUrl: './cliente-form.component.html',
  styleUrls: ['./cliente-form.component.css']
})
export class ClienteFormComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.createForm(new Cliente());
  }

  formCliente: FormGroup;

  createForm(cliente: Cliente) {
    this.formCliente = new FormGroup({
      nome: new FormControl(cliente.nome),
      dataDeNascimento: new FormControl(cliente.dataNascimento),
      cpf: new FormControl(cliente.cpf)
    })
  }

  onSubmit() {
    //console.log(this.formCliente.value);

    this.http.post<any>('localhost:8080/cliente/add', this.formCliente.value).subscribe(data => {
      console.log(data);
      error: error => console.error('There was an error!', error)
    });

    this.createForm(new Cliente());
  }

}
