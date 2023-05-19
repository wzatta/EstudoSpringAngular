import { TestBed } from '@angular/core/testing';

import { AlmoxSubResolver } from './almox-sub.resolver';

describe('AlmoxSubResolver', () => {
  let resolver: AlmoxSubResolver;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    resolver = TestBed.inject(AlmoxSubResolver);
  });

  it('should be created', () => {
    expect(resolver).toBeTruthy();
  });
});
