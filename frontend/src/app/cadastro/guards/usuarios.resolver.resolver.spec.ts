import { TestBed } from '@angular/core/testing';

import { UsuariosResolverResolver } from './usuarios.resolver.resolver';

describe('UsuariosResolverResolver', () => {
  let resolver: UsuariosResolverResolver;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    resolver = TestBed.inject(UsuariosResolverResolver);
  });

  it('should be created', () => {
    expect(resolver).toBeTruthy();
  });
});
