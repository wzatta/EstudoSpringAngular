import { TestBed } from '@angular/core/testing';

import { SbgrupoResolver } from './sbgrupo.resolver';

describe('SbgrupoResolver', () => {
  let resolver: SbgrupoResolver;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    resolver = TestBed.inject(SbgrupoResolver);
  });

  it('should be created', () => {
    expect(resolver).toBeTruthy();
  });
});
