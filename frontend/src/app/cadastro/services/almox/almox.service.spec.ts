import { TestBed } from '@angular/core/testing';

import { AlmoxService } from './almox.service';

describe('AlmoxService', () => {
  let service: AlmoxService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AlmoxService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
