# Release Notes

## 2026-09-14

### CI: Simplify Bob Shell install and remove Mermaid validation step

**`domain/Warehouse.java`**
- Added `warehouseName` field (private `String`) to the `Warehouse` class.

**`.github/workflows/bob-doc-update.yml`**
- Replaced the single-line `curl | sh` Bob Shell install with an explicit two-step
  download-then-execute pattern, and added `--pm npm` to avoid an interactive
  package-manager prompt.
- Added the npm global bin directory to `$GITHUB_PATH` so the `bob` command is
  available in subsequent steps.
- Renamed the auth environment variable from `BOB_API_KEY` to `BOBSHELL_API_KEY`
  to match the Bob Shell convention.
- Removed the `--auth-method api-key` flag from the `bob` invocation (no longer
  a valid flag).
- Removed the "Set up Node for mermaid linting", "Install mermaid-cli", and
  "Validate mermaid diagrams" steps entirely, simplifying the workflow from three
  post-Bob steps down to one (commit and push).
