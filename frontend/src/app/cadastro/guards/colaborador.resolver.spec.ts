import { TestBed } from '@angular/core/testing';

import { ColaboradorResolver } from './colaborador.resolver';

describe('ColaboradorResolver', () => {
  let resolver: ColaboradorResolver;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    resolver = TestBed.inject(ColaboradorResolver);
  });

  it('should be created', () => {
    expect(resolver).toBeTruthy();
  });
});
