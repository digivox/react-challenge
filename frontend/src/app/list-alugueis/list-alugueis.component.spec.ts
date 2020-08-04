import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListAlugueisComponent } from './list-alugueis.component';

describe('ListAlugueisComponent', () => {
  let component: ListAlugueisComponent;
  let fixture: ComponentFixture<ListAlugueisComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListAlugueisComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListAlugueisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
