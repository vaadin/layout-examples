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
            <h1>Layout Examples for Vaadin 14</h1>
            <p>Pick a layout from the menu.</p>
        `;
    }

    static get is() {
        return 'intro-view';
    }
}

customElements.define(IntroView.is, IntroView);
