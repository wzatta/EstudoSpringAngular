import { TestBed } from '@angular/core/testing';

import { OsfilialService } from './osfilial.service';

describe('OsfilialService', () => {
  let service: OsfilialService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OsfilialService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
