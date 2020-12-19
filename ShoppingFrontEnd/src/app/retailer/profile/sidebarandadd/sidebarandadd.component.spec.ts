import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SidebarandaddComponent } from './sidebarandadd.component';

describe('SidebarandaddComponent', () => {
  let component: SidebarandaddComponent;
  let fixture: ComponentFixture<SidebarandaddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SidebarandaddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SidebarandaddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
