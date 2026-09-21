# Project Notes

### 1. Check Existence vs. Fetching from Database

If you need the object, **do not** call `existsById()` first:
```java
// ❌ Avoid: 2 database queries
if (!repo.existsById(id)) { ... }
Student student = repo.findById(id).get();
```

Instead, use `findById()` directly:
```java
// ✅ Better: 1 database query
Student student = repo.findById(id)
    .orElseThrow(() -> new RuntimeException("Not found with id: " + id));
```

**Rule of thumb:**
- If you **need the object** later ➡️ use `findById().orElseThrow()`
- If you **only need yes/no** (e.g., checking duplicate email, or before deleting) ➡️ use `existsBy...()`
