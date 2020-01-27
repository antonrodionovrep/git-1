import { AngularfrontPage } from './app.po';

describe('angularfront App', function() {
  let page: AngularfrontPage;

  beforeEach(() => {
    page = new AngularfrontPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
