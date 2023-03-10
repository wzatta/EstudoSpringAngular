import { TestBed } from '@angular/core/testing';

import { OsfilialResolver } from './osfilial.resolver';

describe('OsfilialResolver', () => {
  let resolver: OsfilialResolver;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    resolver = TestBed.inject(OsfilialResolver);
  });

  it('should be created', () => {
    expect(resolver).toBeTruthy();
  });
});
