package com.max.practice.excercise;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


public class LFUCacheTest {
  private LFUCache cache = new LFUCache(2);

  @Test
  public void case1() {
    cache.put(1, 1);
    cache.put(2, 2);
    assertThat(cache.get(1)).isEqualTo(1);
    cache.put(3, 3);
    assertThat(cache.get(2)).isEqualTo(-1);
    assertThat(cache.get(3)).isEqualTo(3);
    cache.put(4, 4);
    assertThat(cache.get(1)).isEqualTo(-1);
    assertThat(cache.get(3)).isEqualTo(3);
    assertThat(cache.get(4)).isEqualTo(4);

  }

  @Test
  public void shouldPutAndGet() {
    cache.put(1, 1);

    assertThat(cache.get(1)).isEqualTo(1);
  }

  @Test
  public void shouldGetUpdatedValueWhenKeyWasReplaced() {
    cache.put(1, 1);
    cache.put(1, 2);

    assertThat(cache.get(1)).isEqualTo(2);
  }

  @Test
  public void shouldEvictLFUWhenReachedCapacity() {
    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);
    cache.put(3, 3);

    assertThat(cache.get(3)).isEqualTo(3);
    assertThat(cache.get(2)).isEqualTo(-1);
  }


  @Test
  public void shouldNotAddWhenCapacityIsZero() {
    cache = new LFUCache(0);
    cache.put(1, 1);
    assertThat(cache.get(1)).isEqualTo(-1);
  }
}