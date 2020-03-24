import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `centered-content-view`
 *
 * CenteredContentView element.
 *
 * @customElement
 * @polymer
 */
class CenteredContentView extends PolymerElement {

    static get template() {
        return html`
            <style include="common-styles">
                :host {
                    display: block;
                }

                .wrapper {
                    margin: 0 auto;
                    max-width: 960px;
                    padding: 0 var(--lumo-space-l);
                    background: var(--lumo-base-color) linear-gradient(hsla(349, 100%, 60%, .2), hsla(349, 100%, 60%, .2));
                }
            </style>
            <div class="wrapper">
                <div id="main"></div>
            </div>
            <vaadin-button
                    style = "margin-left: 40%;"
                    onclick = "window.location.href='https://github.com/vaadin/layout-examples/blob/master/src/main/java/com/vaadin/demo/views/CenteredContentView.java'">
              <img src = "icons/Github.png" slot="prefix"></img>
              View source code
            </vaadin-button>
        `;
    }

    static get is() {
        return 'centered-content-view';
    }
}

customElements.define(CenteredContentView.is, CenteredContentView);
