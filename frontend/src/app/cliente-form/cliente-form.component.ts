import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-cliente-form',
  templateUrl: './cliente-form.component.html',
  styleUrls: ['./cliente-form.component.css']
})
export class ClienteFormComponent implements OnInit {

  ngOnInit() {
    this.createForm(new Cliente());
  }

  formCliente: FormGroup;

  createForm(cliente: Cliente) {
    this.formCliente = new FormGroup({
      nome: new FormControl(cliente.nome),
      dataNascimento: new FormControl(cliente.dataNascimento),
      cpf: new FormControl(cliente.cpf)
    })
  }

  onSubmit() {
    console.log(this.formCliente.value);

    this.createForm(new Cliente());
  }

}
