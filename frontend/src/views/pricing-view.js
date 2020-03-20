import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '../components/ex-card.js';

/**
 * `pricing-view`
 *
 * PricingView element.
 *
 * @customElement
 * @polymer
 */
class PricingView extends PolymerElement {

    static get template() {
        return html`
            <style include="common-styles">
                :host {
                    display: block;
                }

                .wrapper {
                    margin: 0 auto; /* Horizontally center the layout grid if there is space around it */
                    max-width: 960px;
                    padding: 0 var(--lumo-space-m);
                }

                #header {
                    padding: var(--lumo-space-wide-l);
                    margin-bottom: var(--lumo-space-xl);
                    box-shadow: 0 0 0 1px var(--lumo-contrast-5pct), var(--lumo-box-shadow-xs);
                }

                #header h2 {
                    font-size: 1.4rem;
                    margin: 0;
                }

                @media screen and (max-width: 759px) {
                    #header {
                        text-align: center;
                    }

                    #header vaadin-menu-bar {
                        display: inline-block;
                        max-width: 100%;
                    }
                }

                @media screen and (min-width: 760px) {
                    #header {
                        display: flex;
                        align-items: baseline;
                    }

                    #header h2 {
                        flex: 1;
                    }
                }

                .card-list {
                    display: flex;
                    margin: var(--lumo-space-xl) calc(var(--lumo-space-m) * -1);
                    flex-wrap: wrap;
                }

                .card-list > ex-card {
                    flex: 1 0 210px;
                    margin: var(--lumo-space-m);
                }

                ex-card ul,
                #footer ul {
                    padding: 0;
                }

                ex-card li,
                #footer li {
                    list-style: none;
                }

                ex-card vaadin-button {
                    width: 100%;
                    font-size: var(--lumo-font-size-l);
                    --lumo-button-size: 2.4em;
                }

                .hero {
                    margin: 0 auto;
                    max-width: 700px;
                    text-align: center;
                }

                .hero p {
                    font-size: var(--lumo-font-size-l);
                }

                #footer {
                    margin-top: var(--lumo-space-xl);
                    border-top: 1px solid var(--lumo-contrast-30pct);
                    padding-top: var(--lumo-space-xl);
                    padding-bottom: var(--lumo-space-l);
                    display: flex;
                    flex-wrap: wrap;
                    --lumo-primary-text-color: var(--lumo-contrast-70pct);
                }

                #footer > div {
                    flex: 1 0 20%;
                }

                #footer h2 {
                    font-size: var(--lumo-font-size-l);
                }

                #footer ul {
                    margin: var(--lumo-space-s) 0;
                }

                .copyright {
                    font-size: var(--lumo-font-size-s);
                    color: var(--lumo-contrast-60pct);
                }

                .copyright-box > [icon] {
                    color: #00b4f0;
                }

                @media screen and (max-width: 789px) {
                    #footer .copyright-box {
                        flex-basis: 100%;
                    }

                    #footer > div {
                        flex: 1 0 45%;
                    }
                }
            </style>
            <div id="header"></div>
            <div class="wrapper">
                <div id="main"></div>
                <div id="footer"></div>
            </div>
            <vaadin-button
                    style = "margin-left: 40%;"
                    onclick = "window.location.href='https://github.com/vaadin/layout-examples/blob/master/src/main/java/com/vaadin/demo/views/PricingView.java'">
              <img src = "icons/Github.png" slot="prefix"></img>
              View source code
            </vaadin-button>
        `;
    }

    static get is() {
        return 'pricing-view';
    }
}

customElements.define(PricingView.is, PricingView);
