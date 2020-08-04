import { TestBed } from '@angular/core/testing';

import { HttpUtilService } from './http-util.service';

describe('HttpUtilService', () => {
  let service: HttpUtilService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpUtilService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
