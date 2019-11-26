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
        `;
    }

    static get is() {
        return 'centered-content-view';
    }
}

customElements.define(CenteredContentView.is, CenteredContentView);
