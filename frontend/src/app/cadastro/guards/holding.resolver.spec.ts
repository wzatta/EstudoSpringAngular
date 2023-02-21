import { TestBed } from '@angular/core/testing';

import { HoldingResolver } from './holding.resolver';

describe('HoldingResolver', () => {
  let resolver: HoldingResolver;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    resolver = TestBed.inject(HoldingResolver);
  });

  it('should be created', () => {
    expect(resolver).toBeTruthy();
  });
});
