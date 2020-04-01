import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-button/vaadin-button.js';
import '../components/ex-card.js';

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

                main {
                    margin: 0 auto;
                    max-width: 960px;
                    padding: 0 var(--lumo-space-m);
                }

                kbd {
                    font-family: var(--lumo-font-family);
                    display: inline-block;
                    background: var(--lumo-contrast-10pct);
                    padding: var(--lumo-space-wide-xs);
                    margin: 0 var(--lumo-space-wide-xs);
                    border-radius: var(--lumo-border-radius-s);
                    box-shadow: 0 0 0 1px var(--lumo-contrast-10pct), var(--lumo-box-shadow-xs);
                    font-size: var(--lumo-font-size-m);
                }

                .card-list {
                    display: flex;
                    margin: var(--lumo-space-xl) calc(var(--lumo-space-m) * -1);
                    flex-wrap: wrap;
                }

                .card-list > ex-card {
                    flex: 1 0 210px;
                    margin: var(--lumo-space-s);
                    --excard-padding: var(--lumo-space-wide-m);
                }
            </style>
            <main>
                <h1>Layout Examples for Vaadin 14</h1>

                <p>
                    All of the examples are viewable with two themes (light and dark).
                    Toggle between the themes by clicking the button below or by pressing <kbd>T</kbd> on your keyboard.
                </p>
                <p><vaadin-button on-click="toggleTheme">Toggle Theme</vaadin-button></p>

                <h2>Basic examples</h2>
                <p>
                    Examples showcasing individual building blocks or specific features for creating layouts.
                    Note that the examples marked with "CSS Grid" are implemented using
                    <a href="https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Grid_Layout">CSS Grid Layout</a>
                    which is a very flexible way to create layouts but notably doesn't work in IE 11, Safari 9 or older browsers. 
                </p>
                <div class="card-list">
                    <ex-card>
                        <a slot="title" router-link href="horizontal">Horizontal Layouts</a>
                        <p>Simple examples using a HorizontalLayout</p>
                    </ex-card>
			        <ex-card>
				        <a slot="title" router-link href="vertical">Vertical Layouts</a>
				        <p>Simple examples using a VerticalLayout</p>
			        </ex-card>
                </div>

                <div class="card-list">
                    <ex-card>
                        <a slot="title" router-link href="three-columns">Three Columns (CSS Grid)</a>
                        <p>A grid layout with header, footer and two sidebars</p>
                    </ex-card>
                    <ex-card>
                        <a slot="title" router-link href="two-columns">Two Columns (CSS Grid)</a>
                        <p>A grid layout with header, footer and one sidebar</p>
                    </ex-card>
                    <ex-card>
                        <a slot="title" router-link href="centered-content">Centered Content</a>
                        <p>A horizontally centered container with a maximum width</p>
                    </ex-card>
                </div>

                <h2>Complete layout examples</h2>
                <p>Styled ready to use layouts which you may use as is or customize to your liking.</p>
                <div class="card-list">
                    <ex-card>
                        <a slot="title" router-link href="pricing">Pricing</a>
                        <p>Pricing page</p>
                    </ex-card>
                    <ex-card>
                        <a slot="title" router-link href="fixed-nav-sticky-footer">Fixed Nav &amp; Sticky Footer</a>
                        <p>
                            Navigation bar fixed to the top of the viewport.
                            Footer at the bottom of the viewport will get pushed
                            down if there is more content than fits the viewport.
                        </p>
                    </ex-card>
                    <ex-card>
                        <a slot="title" router-link href="app-layout-basic">Basic App Layout</a>
                        <p>A basic example of using <a href="https://vaadin.com/components/vaadin-app-layout/"><code>AppLayout</code></a></p>
                    </ex-card>
                    <ex-card>
                        <a slot="title" router-link href="login-form">Login Form</a>
                        <p>A centered login form</p>
                    </ex-card>
                    <ex-card>
                        <a slot="title" router-link href="checkout-form">Checkout form</a>
                        <p>A checkout form including a billing address and summary of shopping card</p>
                    </ex-card>
                    <ex-card>
                        <a slot="title" router-link href="marketing">Marketing page</a>
                        <p>Typical web page including a main part and three responsive article cards under it.</p>
                    </ex-card>
                    <ex-card>
                        <a slot="title" router-link href="carousel">Carousel</a>
                        <p>A carousel example</p>
                    </ex-card>
                    <ex-card>
                        <a slot="title" router-link href="listing">Listing form</a>
                        <p>Searching and filtering products</p>
                    </ex-card>
                </div>
            </main>
        `;
    }

    static get is() {
        return 'intro-view';
    }

    toggleTheme() {
        window.utils.toggleTheme();
    }
}

customElements.define(IntroView.is, IntroView);
