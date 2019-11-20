import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `intro-view`
 *
 * IntroView element.
 *
 * @customElement
 * @polymer
 */
class IntroView extends PolymerElement {

    static get template() {
        return html`
            <style include="common-styles">
                :host {
                    display: block;
                }
                
                .wrapper {
                    margin: 0 auto;
                    max-width: 960px;
                    padding: 0 var(--lumo-space-m);
                }
            </style>
            <main class="wrapper">
                <h1>Layout Examples for Vaadin 14</h1>
                <p>Pick a layout from the menu.</p>
            </main>
        `;
    }

    static get is() {
        return 'intro-view';
    }
}

customElements.define(IntroView.is, IntroView);
