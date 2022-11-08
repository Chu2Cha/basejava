/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        for (int i = 0; storage[i] != null; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                size++;
                break;
            }
        }
    }

    Resume get(String uuid) {
        if (findIndex(uuid) >= 0)
            return storage[findIndex(uuid)];
        else
            return null;
    }

    void delete(String uuid) {  
        if (findIndex(uuid) >= 0) {
            for (int i = findIndex(uuid); i < size; i++) {
                storage[i] = storage[i + 1];
            }
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll() {
        Resume[] returnArray = new Resume[size];
        for (int i = 0; i < size; i++) {
            returnArray[i] = storage[i];
        }
        return returnArray;
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
