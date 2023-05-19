import { TestBed } from '@angular/core/testing';

import { AlmoxsubService } from './almoxsub.service';

describe('AlmoxsubService', () => {
  let service: AlmoxsubService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AlmoxsubService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
