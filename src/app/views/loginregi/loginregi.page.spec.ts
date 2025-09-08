import { ComponentFixture, TestBed } from '@angular/core/testing';
import { LoginregiPage } from './loginregi.page';

describe('LoginregiPage', () => {
  let component: LoginregiPage;
  let fixture: ComponentFixture<LoginregiPage>;

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginregiPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
