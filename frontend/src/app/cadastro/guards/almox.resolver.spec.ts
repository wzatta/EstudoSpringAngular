import { TestBed } from '@angular/core/testing';

import { AlmoxResolver } from './almox.resolver';

describe('AlmoxResolver', () => {
  let resolver: AlmoxResolver;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    resolver = TestBed.inject(AlmoxResolver);
  });

  it('should be created', () => {
    expect(resolver).toBeTruthy();
  });
});
