import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListDevolucoesComponent } from './list-devolucoes.component';

describe('ListDevolucoesComponent', () => {
  let component: ListDevolucoesComponent;
  let fixture: ComponentFixture<ListDevolucoesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListDevolucoesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListDevolucoesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
