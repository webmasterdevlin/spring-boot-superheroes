/// <reference types="cypress"/>

declare namespace Cypress {
  interface Chainable {
    getCommand(url: string, responseBody: Array<T>): void;
    deleteCommand(url: string): void;
    postCommand(url: string, requestBody: T): void;
    SetupInputFieldsCommand(): void;
    NavigateByTestIdCommand(testId: string): void;
  }
}
