/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        storage[size++] = r;
    }

    Resume get(String uuid) {
        try{
            return storage[findIndex(uuid)];
        } catch (ArrayIndexOutOfBoundsException e){
            return null;
        }
    }

    void delete(String uuid) {
        try {
            for (int i = findIndex(uuid); i < size; i++) {
                storage[i] = storage[i + 1];
            }
            size--;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Nothing to delete");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        for (int i = 0; i < size; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    int size() {
        return size;
    }

    private int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
