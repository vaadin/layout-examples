import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-button/vaadin-button.js';
import '@vaadin/vaadin-text-field/vaadin-password-field.js';
import '@vaadin/vaadin-text-field/vaadin-text-field.js';

/**
 * `login-form-view`
 *
 * LoginFormView element.
 *
 * @customElement
 * @polymer
 */
class LoginFormView extends PolymerElement {

    static get template() {
        return html`
            <style include="common-styles">
                :host {
                    display: block;
                }

                .wrapper {
                    margin: 0 auto;
                    max-width: 400px;
                    padding: var(--lumo-space-xl) var(--lumo-space-l) 0;
                }

                .card {
                    box-shadow: 0 0 0 1px var(--lumo-contrast-5pct), var(--lumo-box-shadow-s);
                    border-radius: var(--lumo-border-radius-m);
                    background: var(--lumo-base-color) linear-gradient(var(--lumo-tint-5pct), var(--lumo-tint-5pct));
                    padding: var(--lumo-space-m);
                    
                    display: flex;
                    flex-direction: column;
                }

                h3 {
                    margin-top: var(--lumo-space-s);
                }

                .card vaadin-button {
                    margin: var(--lumo-space-m) 0;
                }

                #forgotPasswordButton {
                    margin: 0;
                }
            </style>
            <div class="wrapper">
                <div class="card">
                    <h3>Log in</h3>
                    <vaadin-text-field id="usernameField" label="Username" autocomplete="username" required></vaadin-text-field>
                    <vaadin-password-field id="passwordField" label="Password" autocomplete="current-password" required></vaadin-password-field>
                    <vaadin-button id="loginButton" theme="primary">Log in</vaadin-button>
                    <vaadin-button id="forgotPasswordButton" theme="tertiary-inline">Forgot password</vaadin-button>
                </div>
                <vaadin-button
                        style = "margin-left: 30%;"
                        onclick = "window.location.href='https://github.com/vaadin/layout-examples/blob/master/src/main/java/com/vaadin/demo/views/LoginFormView.java'">
                  <img src = "icons/Github.png" slot="prefix"></img>
                  View source code
                </vaadin-button>
            </div>
        `;
    }

    static get is() {
        return 'login-form-view';
    }
}

customElements.define(LoginFormView.is, LoginFormView);
