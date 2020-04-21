const okta = require('@okta/okta-sdk-nodejs');

const client = new okta.Client({
  orgUrl: 'https://dev-313834.okta.com',
  token: '00KUNtLBYsfb_Hmx88HeHQ2Gbqb5xl-A2195icMRrT'
});

module.exports = client;