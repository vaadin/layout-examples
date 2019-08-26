import {PolymerElement} from '@polymer/polymer/polymer-element.js';
import {html} from '@polymer/polymer/lib/utils/html-tag.js';

import '@vaadin/vaadin-board/vaadin-board.js';
import '@vaadin/vaadin-charts/vaadin-chart.js';
import '@vaadin/vaadin-lumo-styles/all-imports.js';

class DashboardView extends PolymerElement {
  static get template() {
    return html`
      <style include="shared-styles lumo-badge lumo-typography">
        :host {
          background-color: var(--lumo-contrast-10pct);
          box-sizing: border-box;
          display: block;
          font-size: var(--lumo-font-size-m);
          height: 100%;
          overflow: auto;
          padding: var(--lumo-space-m) var(--lumo-space-l);
        }

        vaadin-board {
          margin: 0 auto;
          max-width: 1024px;
        }

        /* Wrapper */
        .wrapper {
          display: flex;
          padding: var(--lumo-space-s);
        }

        /* Card */
        .card {
          align-items: baseline;
          background-color: var(--lumo-base-color);
          border-radius: var(--lumo-border-radius);
          box-shadow: var(--lumo-box-shadow-xs);
          display: flex;
          flex-direction: column;
          overflow: hidden;
          width: 100%;
        }

        .card h2 {
          margin-bottom: 0;
          margin-top: var(--lumo-space-m);
        }

        .card h3 {
          margin-bottom: var(--lumo-space-xs);
          margin-left: var(--lumo-space-m);
          margin-top: var(--lumo-space-m);
        }

        /* Spacing */
        .space-m {
          padding: var(--lumo-space-m);
        }

        /* Text colors */
        .error-text {
          color: var(--lumo-error-text-color);
        }

        .primary-text {
          color: var(--lumo-primary-text-color);
        }

        .secondary-text {
          color: var(--lumo-secondary-text-color);
        }

        .success-text {
          color: var(--lumo-success-text-color);
        }

        /* Charts */
        vaadin-chart {
          padding-top: var(--lumo-space-s);
        }

        /* Grid */
        vaadin-grid {
          height: 300px;
        }
      </style>

      <vaadin-board>
            <vaadin-board-row>
              <div class="wrapper">
                <div class="card space-m">
                  <span theme="badge">Users</span>
                  <h2 class="primary-text">[[currentUsers]]</h2>
                  <span class="secondary-text">Current users in the app</span>
                </div>
              </div>
              <div class="wrapper">
                <div class="card space-m">
                  <span theme="badge success">Events</span>
                  <h2 class="success-text">[[numEvents]]</h2>
                  <span class="secondary-text">Events from the views</span>
                </div>
              </div>
              <div class="wrapper">
                <div class="card space-m">
                  <span theme="badge error">Conversion</span>
                  <h2 class="error-text">[[conversionRate]]%</h2>
                  <span class="secondary-text">User conversion rate</span>
                </div>
              </div>
            </vaadin-board-row>
        <div class="wrapper">
          <div class="card">
            <vaadin-chart
              type="column"
              id="monthlyVisitors"
              title="Monthly visitors per city">
            </vaadin-chart>
          </div>
        </div>
        <vaadin-board-row>
          <div class="wrapper">
            <div class="card">
              <h3>Service health</h3>
              <vaadin-grid id="grid" theme="no-border"></vaadin-grid>
            </div>
          </div>
          <div class="wrapper">
            <div class="card">
              <vaadin-chart
                id="responseTimes"
                title="Response times">
              </vaadin-chart>
            </div>
          </div>
        </vaadin-board-row>
    `;
  }

  static get is() {
    return 'dashboard-view';
  }

  static get properties() {
    return {
      // Declare your properties here.
    };
  }
}

customElements.define(DashboardView.is, DashboardView);
