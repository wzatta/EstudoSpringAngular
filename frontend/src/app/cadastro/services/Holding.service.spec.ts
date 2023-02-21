/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { HoldingService } from './Holding.service';

describe('Service: Holding', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HoldingService]
    });
  });

  it('should ...', inject([HoldingService], (service: HoldingService) => {
    expect(service).toBeTruthy();
  }));
});
