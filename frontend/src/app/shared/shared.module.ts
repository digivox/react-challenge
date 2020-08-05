import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StatusPipe } from './pipes/status.pipe';
import { DataPipe } from './pipes/data.pipe';


@NgModule({
  declarations: [
    StatusPipe,
    DataPipe
  ],
  imports: [
    CommonModule
  ],
  exports: [
    StatusPipe,
    DataPipe
  ],
})
export class SharedModule { }