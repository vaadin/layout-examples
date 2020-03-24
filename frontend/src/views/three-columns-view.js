import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `three-columns-view`
 *
 * ThreeColumnsView element.
 *
 * @customElement
 * @polymer
 */
class ThreeColumnsView extends PolymerElement {

    static get template() {
        return html`
            <style include="common-styles">
                :host {
                    display: block;
                }

                .wrapper {
                    margin: 0 auto; /* Horizontally center the layout grid if there is space around it */
                }

                #sidebarLeft {
                    grid-area: nav;
                    background: var(--lumo-base-color) linear-gradient(hsla(125, 100%, 60%, .2), hsla(125, 100%, 60%, .2));
                }

                #header {
                    grid-area: header;
                    background: var(--lumo-base-color) linear-gradient(hsla(349, 100%, 60%, .2), hsla(349, 100%, 60%, .2));
                }

                #sidebarRight {
                    grid-area: aside;
                    background: var(--lumo-base-color) linear-gradient(hsla(44, 100%, 60%, .2), hsla(44, 100%, 60%, .2));
                }

                #main {
                    grid-area: content;
                    background: var(--lumo-base-color) linear-gradient(hsla(227, 100%, 60%, .2), hsla(227, 100%, 60%, .2));
                }

                #footer {
                    grid-area: footer;
                    background-color: lightcoral;
                    background: var(--lumo-base-color) linear-gradient(hsla(318, 100%, 60%, .2), hsla(318, 100%, 60%, .2));
                }

                @media only screen and (max-width: 699px) {
                    .wrapper {
                        display: grid;
                        width: 90%;
                        grid-template-columns: auto ;
                        grid-template-rows: auto ;
                        grid-template-areas: "nav"
                        "header"
                        "content"
                        "aside"
                        "footer";
                    }
                }

                @media only screen and (min-width: 700px) and (max-width: 979px) {
                    .wrapper {
                        display:grid;
                        width: 90%;
                        grid-template-columns: 20% 5% auto ;
                        grid-template-rows: auto ;
                        grid-template-areas: "header header header"
                        "nav . content"
                        "aside . content"
                        "footer footer footer";
                    }
                }

                @media only screen and (min-width: 980px) {
                    .wrapper {
                        display: grid;
                        grid-template-columns: 200px 40px auto 40px 200px;
                        grid-template-rows: auto ;
                        grid-template-areas: "header header header header header"
                        "nav . content . aside"
                        "footer footer footer footer footer";
                        max-width: 1100px;
                    }
                }
            </style>
            <article class="wrapper">
                <div id="sidebarLeft"></div>
                <div id="header"></div>
                <div id="main"></div>
                <div id="sidebarRight"></div>
                <div id="footer"></div>
            </article>
            <vaadin-button
                    style = "margin-left: 40%;"
                    onclick = "window.location.href='https://github.com/vaadin/layout-examples/blob/master/src/main/java/com/vaadin/demo/views/ThreeColumnsView.java'">
              <img src = "icons/Github.png" slot="prefix"></img>
              View source code
            </vaadin-button>
        `;
    }

    static get is() {
        return 'three-columns-view';
    }
}

customElements.define(ThreeColumnsView.is, ThreeColumnsView);
