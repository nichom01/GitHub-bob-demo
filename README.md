# docs-that-update-themselves (demo)

A minimal repository demonstrating a GitHub Action that keeps documentation
in sync with code automatically, using IBM Bob Shell.

## Structure

```
.
├── .github/workflows/bob-doc-update.yml   # CI workflow — see below
├── domain/
│   └── Warehouse.java                     # sample domain class
└── docs/
    ├── RELEASE_NOTES.md                   # auto-updated on every PR
    └── diagrams/
        ├── class-diagram.md               # mermaid classDiagram, auto-regenerated
        └── workflow.md                    # mermaid flowchart, auto-regenerated
```

## How it works

On every pull request (`opened` or `synchronize`), `.github/workflows/bob-doc-update.yml`:

1. Checks out the PR branch with full history.
2. Scaffolds `docs/RELEASE_NOTES.md`, `docs/diagrams/class-diagram.md`, and
   `docs/diagrams/workflow.md` if they don't already exist.
3. Runs **Bob Shell** with a prompt scoped to those three files, asking it to
   update release notes and regenerate the mermaid diagrams based on the diff
   and the current state of `domain/`.
4. Validates every generated mermaid block with `@mermaid-js/mermaid-cli`,
   failing the job if any diagram doesn't parse.
5. Commits the updated docs back onto the PR branch.

## Requirements

- A `BOB_API_KEY` repository secret (Bob Shell API key, Inference scope).
- `contents: write` and `pull-requests: write` permissions (already set in
  the workflow) so the job can push back to the PR branch.

## Try it

Make a change to `domain/Warehouse.java` — add a field, a method, or a new
class — open a PR, and watch the workflow regenerate the docs to match.
