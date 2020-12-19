import { TestBed } from '@angular/core/testing';

import { RetailerLoginService } from './retailer-login.service';

describe('RetailerLoginService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RetailerLoginService = TestBed.get(RetailerLoginService);
    expect(service).toBeTruthy();
  });
});
