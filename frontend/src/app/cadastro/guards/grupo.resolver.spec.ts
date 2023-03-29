import { TestBed } from '@angular/core/testing';

import { GrupoResolver } from './grupo.resolver';

describe('GrupoResolver', () => {
  let resolver: GrupoResolver;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    resolver = TestBed.inject(GrupoResolver);
  });

  it('should be created', () => {
    expect(resolver).toBeTruthy();
  });
});
