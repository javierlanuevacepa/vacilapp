import { TestBed } from '@angular/core/testing';

import { ApiEvent1Service } from './api-event1.service';

describe('ApiEvent1Service', () => {
  let service: ApiEvent1Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiEvent1Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
