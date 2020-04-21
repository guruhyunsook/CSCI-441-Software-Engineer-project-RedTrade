import React from 'react';
import { Link } from 'react-router-dom';
import { withAuth } from '@okta/okta-react';

export default withAuth(
  class Navigation extends React.Component {
    constructor(props) {
      super(props);
      this.state = { authenticated: null };
      this.checkAuthentication = this.checkAuthentication.bind(this);
      this.checkAuthentication();
    }

    async checkAuthentication() {
      const authenticated = await this.props.auth.isAuthenticated();
      if (authenticated !== this.state.authenticated) {
        this.setState({ authenticated });
      }
    }

    componentDidUpdate() {
      this.checkAuthentication();
    }

    render() {
      if (this.state.authenticated === null) return null;
      const authNav = this.state.authenticated ? (
        <ul className="auth-nav navbar-nav">.
          <li class="nav-item active">
            <Link class="nav-link" to="/profile">Profile</Link>
          </li>
          <li class="nav-item active">
            <Link class="nav-link" to="/research">Research</Link>
          </li>
          <li class="nav-item active">
            <a
              class="nav-link"
              href="javascript:void(0)"
              onClick={() => this.props.auth.logout()}
            >
              Logout
            </a>
          </li>
        </ul>
      ) : (
          <ul className="auth-nav navbar-nav">
            <li class="nav-item active">
              <a
                class="nav-link"
                href="javascript:void(0)"
                onClick={() => this.props.auth.login()}
              >
                Login
            </a>
            </li>
            <li class="nav-item active">
              <Link class="nav-link" to="/register">Register</Link>
            </li>
          </ul>
        );
      return (
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <a class="navbar-brand" href="/">Red Trade</a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNav">
            {authNav}
          </div>
        </nav>
      );
    }
  }
);