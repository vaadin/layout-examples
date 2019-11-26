import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `ex-card`
 *
 * ExCard example card component.
 *
 * @customElement
 * @polymer
 */
class ExCard extends PolymerElement {

    static get template() {
        return html`
            <style include="common-styles">
                :host {
                    display: flex;
                    flex-direction: column;
                    box-shadow: 0 0 0 1px var(--lumo-contrast-5pct), var(--lumo-box-shadow-xs);
                    border-radius: var(--lumo-border-radius-m);
                    background: var(--lumo-base-color) linear-gradient(var(--lumo-tint-5pct), var(--lumo-tint-5pct));
                }

                header {
                    background: var(--lumo-shade-5pct);
                    border-bottom: 1px solid var(--lumo-shade-20pct);
                    padding: var(--lumo-space-xs);
                    text-align: center;
                    font-size: 1.4rem;
                }

                main {
                    padding: var(--excard-padding, var(--lumo-space-m));
                    text-align: center;
                }
            </style>
            <header><slot name="title">[[title]]</slot></header>
            <main><slot></slot></main>
        `;
    }

    static get is() {
        return 'ex-card';
    }

    static get properties() {
        return {
            title: String
        };
    }
}

customElements.define(ExCard.is, ExCard);
